package lr10.tasks;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.*;
import java.util.stream.IntStream;

public class Task2 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String path = "./src/lr10/tasks/task2.xml";
        actions(path);
    }

    private static void actions(String path) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("1 - вывести весь список товаров");
            System.out.println("2 - поиск товара по названию");
            System.out.println("3 - добавить новый товар");
            System.out.println("4 - удалить товар");
            System.out.println("5 - выход");

            int number = scanner.nextInt();

            switch (number) {
                case 1:
                    listData(path);
                    break;
                case 2:
                    findPart(path);
                    break;
                case 3:
                    addPart(path);
                    break;
                case 4:
                    deletePart(path);
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Неверный ввод. Пожалуйста, введите число от 1 до 5.");
                    break;
            }
        }

        scanner.close();
    }

    private static PartItem[] getData(String path) {
        PartItem[] parts = new PartItem[0];
        try {
            File inputFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            //System.out.println("Корневой элемент: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("part");
            parts = new PartItem[nodeList.getLength()];
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                //System.out.println("\nТекущий элемент: " + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    parts[i] = new PartItem(element.getElementsByTagName("name").item(0).getTextContent(),
                            element.getElementsByTagName("category").item(0).getTextContent(),
                            element.getElementsByTagName("description").item(0).getTextContent(),
                            element.getElementsByTagName("price").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parts;
    }
    private static void listData(String path) {
        PartItem[] parts = getData(path);
        if(parts.length == 0) {
            System.out.println("Данные отсутствуют");
        } else {
            for (PartItem item : parts) {
                System.out.println("Название: " + item.name);
                System.out.println("Категория: " + item.category);
                System.out.println("Описание: " + item.description);
                System.out.println("Цена: " + item.price);
                System.out.println();
            }
        }
    }

    private static void findPart(String path) {
        System.out.println("Введите название товара: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        List<Element> parts = new ArrayList<>(0);
        try {
            File inputFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("part");
            parts = IntStream.range(0, nodeList.getLength())
                    .mapToObj(nodeList::item)
                    .filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
                    .map(Element.class::cast)
                    .filter(element -> name.equals(element.getElementsByTagName("name").item(0).getTextContent()))
                    .toList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (parts.isEmpty()) {
            System.out.println("Товар не найден");
        } else {
            for(Element part : parts) {
                System.out.println("\nPart:");
                System.out.println("Название: " + part.getElementsByTagName("name").item(0).getTextContent());
                System.out.println("Категория: " + part.getElementsByTagName("category").item(0).getTextContent());
                System.out.println("Описание: " + part.getElementsByTagName("description").item(0).getTextContent());
                System.out.println("Цена: " + part.getElementsByTagName("price").item(0).getTextContent());
            }
        }
    }

    private static void addPart(String path) {
        try {
            File inputFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            scanner.nextLine();
            System.out.print("Введите название: ");
            String name = scanner.nextLine();
            System.out.print("Введите категорию: ");
            String category = scanner.nextLine();
            System.out.print("Введите описание: ");
            String description = scanner.nextLine();
            System.out.print("Введите цену: ");
            Double price = scanner.nextDouble();

            Element newItem = doc.createElement("part");

            Element elName = doc.createElement("name");
            elName.appendChild(doc.createTextNode(name));
            newItem.appendChild(elName);

            Element elCategory = doc.createElement("category");
            elCategory.appendChild(doc.createTextNode(category));
            newItem.appendChild(elCategory);

            Element elDescription = doc.createElement("description");
            elDescription.appendChild(doc.createTextNode(description));
            newItem.appendChild(elDescription);

            Element elPrice = doc.createElement("price");
            elPrice.appendChild(doc.createTextNode(price.toString()));
            newItem.appendChild(elPrice);

            Element rootElement = doc.getDocumentElement();
            rootElement.appendChild(newItem);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
            transformer.setOutputProperty(OutputKeys.INDENT, "no");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(path));
            transformer.transform(source, result);

            System.out.println("Новый товар успешно добавлен");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deletePart(String path) {
        try {
            File inputFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.print("Введите название: ");
            scanner.nextLine();
            String name = scanner.nextLine();

            NodeList nodeList = doc.getElementsByTagName("part");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    if (element.getElementsByTagName("name").item(0).getTextContent().equals(name)) {
                        node.getParentNode().removeChild(node);
                        System.out.println("Товар успешно удален");
                    }
                }
            }

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
            transformer.setOutputProperty(OutputKeys.INDENT, "no");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(path));
            transformer.transform(source, result);

            System.out.println("Новый товар успешно добавлен");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
