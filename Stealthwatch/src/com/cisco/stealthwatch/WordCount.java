package com.cisco.stealthwatch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCount {
	
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("src/sample.txt");
		Map<String, Integer> result = Files.lines(path)
				.flatMap(line -> Arrays.stream(line.trim().split("\\W+")))
				.map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim())
				.filter(word -> word.length() > 0)
				.map(word -> new SimpleEntry<>(word, 1))
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (v1, v2) -> v1 + v2));
		result.forEach((k, v) -> System.out.println(v + " " + k));
	}
}
