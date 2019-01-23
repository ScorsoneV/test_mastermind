package it.hyperborea.vincenzo.mastermind.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.hyperborea.vincenzo.mastermind.model.Game;
import it.hyperborea.vincenzo.mastermind.model.Ranking;
import it.hyperborea.vincenzo.mastermind.utility.Loggable;

@Service("rankingService")
public class RankingService extends Loggable {

	@Autowired
	private String rankingPath;

	@Autowired
	private String rankingFile;

	private Path checkFile() throws IOException {
		Path pathDir = Paths.get(rankingPath);

		if (Files.notExists(pathDir))
			Files.createDirectory(pathDir);

		Path pathFile = pathDir.resolve(rankingFile);

		if (Files.notExists(pathFile))
			Files.createFile(pathFile);

		return pathFile;
	}

	private Properties readFile() throws IOException {
		Path path = checkFile();

		try (InputStream stream = Files.newInputStream(path)) {
			Properties config = new Properties();
			config.load(stream);
			return config;
		}
	}
	
	private void order(Map<String, String> unordered, Map<String, String> ordered){
		unordered.entrySet().stream().sorted(Map.Entry.<String, String>comparingByValue().reversed())
		.forEachOrdered(x -> ordered.put(x.getKey(), x.getValue()));
	}

	public Ranking getRankingObject() throws IOException {
		Properties properties = readFile();

		Map<String, String> map = new LinkedHashMap<String, String>();
		Ranking ranking = new Ranking();

		for (String name : properties.stringPropertyNames())
			map.put(name, properties.getProperty(name));
		Map<String, String> results = new LinkedHashMap<String, String>();
		order(map, results);
		ranking.setRanking((LinkedHashMap<String, String>) results);
		return ranking;
	}
	
	private void resizeRanking(Map<String, String> map){
		int i = 0;
		
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			++i;
		    Map.Entry<String, String> pair = it.next();
		    if(i>10){
		    	String key = pair.getKey();
		    	map.remove(key);
		    }
		    	
		}
	}

	public boolean insertScore(Game game) throws IOException {
		int score = game.getCurrentPlayer().getScore();
		String username = game.getCurrentPlayer().getUsername();
		Map<String, String> ranking = getRankingObject().getRanking();	
		String playerRanking = ranking.get(username);

		String scoreStr = Integer.toString(score);
		String scoreStrValidate = scoreStr.length()==2?"0"+scoreStr:scoreStr;
		if (playerRanking != null && Integer.parseInt(playerRanking) < score) {
			ranking.put(username, scoreStrValidate);
		} else if (playerRanking == null) {
			ranking.put(username, scoreStrValidate);
		} else {
			return false;
		}

		Map<String, String> results = new LinkedHashMap<String, String>();
		order(ranking, results);
		
		if(results.size()>10)
			resizeRanking(results);
		
		Path path = Paths.get(rankingPath);
		Path file = path.resolve(rankingFile);
		String toWrite="";
		for(Map.Entry<String, String> entry : results.entrySet())
			toWrite += entry.getKey()+"="+entry.getValue()+"\n";
		
		logger.debug(toWrite);
		Files.write(file, toWrite.getBytes());
		
		return true;
	}
	
	
}
