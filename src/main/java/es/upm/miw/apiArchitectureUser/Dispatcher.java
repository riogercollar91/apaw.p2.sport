package es.upm.miw.apiArchitectureUser;

import es.upm.miw.apiArchitectureUser.api.SportResource;
import es.upm.miw.apiArchitectureUser.api.UserResource;
import es.upm.miw.apiArchitectureUser.exceptions.InvalidRequestException;
import es.upm.miw.apiArchitectureUser.exceptions.InvalidUserFieldException;
import es.upm.miw.web.http.HttpRequest;
import es.upm.miw.web.http.HttpResponse;
import es.upm.miw.web.http.HttpStatus;

public class Dispatcher {

	private UserResource userResource = new UserResource();
	private SportResource sportResource = new SportResource();

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"error\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}

	public void doGet(HttpRequest request, HttpResponse response) {
		// **/users
		if ("users".equals(request.getPath())) {
			response.setBody(userResource.userList().toString());
			// **/users/{id}/overage
		} else if ("users".equals(request.paths()[0])) {
			try {
				response.setBody(userResource.userOverage(Integer.valueOf(request.paths()[1])).toString());
			} catch (Exception e) {
				responseError(response, e);
			}
			// **/sports
		} else if ("sports".equals(request.getPath())) {
			response.setBody(sportResource.sportList().toString());
		} else {
			responseError(response, new InvalidRequestException(request.getPath()));
		}
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
		// POST **/users body="userName"
		case "users":
			try {
				userResource.createUser(request.getBody());
				response.setStatus(HttpStatus.CREATED);
			} catch (InvalidUserFieldException e) {
				this.responseError(response, e);
			}
			break;
		// POST sports body="userId:sport"
		case "sports":
			String sport = request.getBody();
			try {
			    sportResource.createSport(sport);
				response.setStatus(HttpStatus.CREATED);
			} catch (Exception e) {
				responseError(response, e);
			}
			break;
		default:
			responseError(response, new InvalidRequestException(request.getPath()));
			break;
		}
	}

	public void doPut(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
		  case "users/uno/sport":
	            String sport = request.getBody();
	            try {
	                if(sport.equals("noDeporte")){
	                    response.setStatus(HttpStatus.BAD_REQUEST);
	                }
	                else{
	                    sportResource.createSport(sport);
	                    response.setStatus(HttpStatus.CREATED);
	                    }
	                    
	            } catch (Exception e) {
	                responseError(response, e);
	            }
	            break;
		  case "users/dos/sport":
              String sport1 = request.getBody();
              try {
                  sportResource.createSport(sport1);
                  response.setStatus(HttpStatus.CREATED);
              } catch (Exception e) {
                  responseError(response, e);
              }
              break;
		default:
			responseError(response, new InvalidRequestException(request.getPath()));
			break;
		}
	}

	private void responseError1(HttpResponse response, String string) {
        // TODO Auto-generated method stub
        
    }

    public void doDelete(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
		default:
			responseError(response, new InvalidRequestException(request.getPath()));
			break;
		}
	}

}
