package multithread.example03_HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Client {

	private static final String SRC_MULTITHREAD_EXAMPLE03_HTTP_SERVER_WAR_AND_PEACE_TXT = "src/multithread/example03_HttpServer/war_and_peace.txt";

	public static void main(String[] args) throws IOException {
		String text = new String(Files.readAllBytes(Paths.get(SRC_MULTITHREAD_EXAMPLE03_HTTP_SERVER_WAR_AND_PEACE_TXT)));
		startServer(text);
	}

	public static void startServer(String text) throws IOException {
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
		server.createContext("/search", new WordCountHandler(text));
		Executor executor = Executors.newFixedThreadPool(1);
		server.setExecutor(executor);
		server.start();
	}	
	
	
	private static class WordCountHandler implements HttpHandler{
		
		private String text;
				

		public WordCountHandler(String text) {
			super();
			this.text = text;
		}

		@Override
		public void handle(HttpExchange httpExchange) throws IOException {
			String 	query = httpExchange.getRequestURI().getQuery();
			String[] keyValue = query.split("=");
			String action = keyValue[0];
			String word = keyValue[1];
			
			if(!action.equals("word")) {
				httpExchange.sendResponseHeaders(400, 0);
				return;
			}
			
			long count = countWord(word);
			
			byte[] response = Long.toString(count).getBytes();
			httpExchange.sendResponseHeaders(200, response.length);
			OutputStream body = httpExchange.getResponseBody();
			body.write(response);
			body.close();
			
		}



		private long countWord(String word) {
			return Arrays.stream(text.split(" ")).filter(s -> word.equals(s)).count();
		}
		
	}

}
