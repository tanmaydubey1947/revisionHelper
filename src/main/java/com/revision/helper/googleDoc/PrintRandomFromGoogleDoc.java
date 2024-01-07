//package com.revision.helper.googleDoc;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//
//import java.io.IOException;
//import java.util.*;
//
//import static com.revision.helper.googleDoc.Constants.*;
//
//public class PrintRandomFromGoogleDoc {
//
//    public static void main(String[] args) throws IOException {
//
//        Document document = Jsoup.connect(DOC_URL).get();
//        String extractedElement = extractElementFromDoc(document);
//        String topics = extractTopics(extractedElement);
//        List<String> topicList = constructTopicsToList(topics);
//        printRandomTopic(topicList);
//    }
//
//    private static String extractElementFromDoc(Document document) {
//        return document.getAllElements().get(40).childNodes().get(18).childNodes().get(0).toString();
//    }
//
//    private static void printRandomTopic(List<String> myList) {
//        Random random = new Random();
//        int randomIndex = random.nextInt(myList.size());
//        String randomElement = myList.get(randomIndex);
//        System.out.println(randomElement);
//    }
//
//    private static List<String> constructTopicsToList(String topics) {
//        String[] lines = topics.replaceAll(END_SUBSTRING, "").split("\\\\n");
//        List<String> myList = new ArrayList<>();
//
//        for (String line : lines) {
//            if (!line.isEmpty()) {
//                myList.add(line);
//            }
//        }
//        return myList;
//    }
//
//    public static String extractTopics(String extractedElement){
//        int startIndex = extractedElement.indexOf(START_SUBSTRING);
//        int endIndex = extractedElement.indexOf(END_SUBSTRING, startIndex + START_SUBSTRING.length());
//        return extractedElement.substring(startIndex, endIndex + END_SUBSTRING.length());
//    }
//
//    public void todoMethod(){
//        /* List<String> myList = new ArrayList<>(Arrays.asList(lines));
//        System.out.println(myList);
//
//        Map<String, List<String>> resultMap = new HashMap<>();
//        String currentKey = null;
//        List<String> currentValues = new ArrayList<>();
//
//        for (String item : myList) {
//            if (item.isEmpty() && currentKey != null) {
//                resultMap.put(currentKey, new ArrayList<>(currentValues));
//                currentValues.clear();
//            } else if (item.isEmpty()) {
//                continue; // Skip consecutive empty lines
//            } else if (currentKey == null) {
//                currentKey = item;
//            } else {
//                currentValues.add(item);
//            }
//        }
//
//
//        // Print the resulting map
//        for (Map.Entry<String, List<String>> entry : resultMap.entrySet()) {
//            System.out.println("Key: " + entry.getKey());
//            System.out.println("List of Values: " + entry.getValue());
//        }*/
//    }
//}
//
//
