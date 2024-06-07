package com.user.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.user.model.User;

@Repository
public class UserRepository {
	private List<User> list;
	
	public UserRepository() {
		// TODO Auto-generated constructor stub
		this.list = new ArrayList<>();
		this.list.add(new User(1, "Mayur", "Banglore"));
		this.list.add(new User(2, "Priya", "Pune"));
		this.list.add(new User(3, "Sid", "Mumbai"));
	}


	public List<User> getAllUsers() {
		return this.list;
	}

	public User findById(int id) {
		for(User user : this.list)
		{
			if (user.getId() == id)
				return user;
		}
		return null;
	}
	
    public List<User> search(String name) {
        return list.stream().filter(x -> x.getName().startsWith(name)).collect(Collectors.toList());
    }

    public User save(User u) {
    	User user = new User();
    	user.setId(u.getId());
    	user.setName(u.getName());
        user.setAddress(u.getAddress());
        list.add(user);
        return user;
    }
    public String delete(Integer id) {
        list.removeIf(x -> x.getId() == (id));
        return null;
    }

    public User update(User user) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (user.getId())) {
                id = user.getId();
                idx = i;
                break;
            }
        }

        User user1 = new User();
        user1.setId(id);
        user1.setName(user.getName());
        user1.setAddress(user.getAddress());
        list.set(idx, user);
        return user1;
    }
}
