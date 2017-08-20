package com.java.hack.service.cakepatterns;

public interface UserServiceComponent extends UserRepositoryComponent {
	
	default UserService getUserService() {
        return new UserService(getUserRepository());
    }
}
