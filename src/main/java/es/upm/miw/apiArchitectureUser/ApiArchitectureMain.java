package es.upm.miw.apiArchitectureUser;

import es.upm.miw.apiArchitectureUser.daos.DaoFactory;
import es.upm.miw.apiArchitectureUser.daos.memory.DaoFactoryMemory;
import es.upm.miw.web.http.HttpMethod;
import es.upm.miw.web.http.HttpRequest;
import es.upm.miw.web.http.HttpResponse;
import upm.jbb.IO;

public class ApiArchitectureMain {

	private Server server = new Server();

	private HttpRequest request = new HttpRequest();

	public void help() {
		IO.getIO().println("GET **/users");
		IO.getIO().println("POST **/users   body=\"userName\"");
		IO.getIO().println("GET **/users/{id}/overage");
		IO.getIO().println("POST **/sports   body=\"userId:sport\"");
		IO.getIO().println("GET **/sports");
	}

	public void demo() {
	    //POST
		request.setMethod(HttpMethod.POST);
		request.setPath("users");
		request.setBody("uno:uno@gmail.com");
		this.request();
		request.setBody("dos:dos@gmail.com");
		this.request();
		request.setBody("dos:dos@gmail.com");
        this.request();
        
        //GET
        request.setMethod(HttpMethod.GET);
        request.setPath("users");
        request.clearQueryParams();
        request.setBody("");
        this.request();
        
        //POST
        request.setPath("sports");
        request.setBody("tenis");
        this.request();
        request.setBody("tenis");
        this.request();
        request.setBody("ajedrez");
        this.request();
        
        //GET
        request.setMethod(HttpMethod.GET);
        request.setPath("users/search?sport=tenis");
        request.clearQueryParams();
        request.setBody("");
        this.request();
//      request.setPath("users");
//      this.request();
//      request.setPath("users/1/overage");
//      this.request();
//      request.setPath("users/2/overage");
//      this.request();
        

//		request.setBody("2:6");
//		this.request();
        

		
		//PUT
        request.setMethod(HttpMethod.PUT);
		request.setPath("users/uno/sport");
        request.setBody("tenis");
        this.request();
        request.setPath("users/uno/sport");
        request.setBody("noDeporte");
        this.request();
        request.setPath("users/dos/sport");
        request.setBody("tenis");
        this.request();
        request.setPath("users/dos/sport");
        request.setBody("ajedres");
        this.request();
        
        
        
		//Exceptions
//		request.setPath("noValid");
//		this.request();
//		request.setPath("users/x/overage");
//		this.request();
//		request.setPath("users/99/overage");
//		this.request();
//		request.setMethod(HttpMethod.POST);
//		request.setPath("sports");
//		request.setBody("99:4");
//		this.request();
	}

	public void httpMethod() {
		request.setMethod((HttpMethod) IO.getIO().select(HttpMethod.values(), "Elige método"));
		this.showStatus();
	}

	public void path() {
		request.setPath(IO.getIO().readString("Path"));
		this.showStatus();
	}

	public void addQueryParam() {
		String[] msgs = { "Nombre", "Valor" };
		String[] campos = { "String", "String" };
		Object[] values = IO.getIO().readForm(campos, msgs);
		request.addQueryParam((String) values[0], (String) values[1]);
		this.showStatus();
	}

	public void clearQueryParams() {
		request.clearQueryParams();
		this.showStatus();
	}

	private void showStatus() {
		IO.getIO().setStatusBar(request.toString());
	}

	public void request() {
		IO.getIO().println(request.toString());
		HttpResponse response = server.request(request);
		IO.getIO().println(response);
		IO.getIO().println("---------------------------------------ooo----------------------------------------");
	}

	public static void main(String[] args) {
		ApiArchitectureMain main = new ApiArchitectureMain();
		IO.getIO().addView(main);
		main.showStatus();
		DaoFactory.setFactory(new DaoFactoryMemory());
	}
}
