package mediator.mediator02_solution;

import java.util.ArrayList;
import java.util.List;

public interface FacebookGroupMediator {
	public void sendMessage(String msg, User user);
	public void registerUser(User user);
}

class FacebookGroupMediatorImpl implements FacebookGroupMediator {
	private List<User> users = new ArrayList<User>();
	
	
	@Override
	public void sendMessage(String msg, User sendUser) {
		for (User user : users) {
			if (user != sendUser) {
				user.receive(msg);
			}
		}
	}

	@Override
	public void registerUser(User user) {
		users.add(user);
	}
	
}