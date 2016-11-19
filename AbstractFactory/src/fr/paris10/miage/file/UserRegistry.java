package fr.paris10.miage.file;

import java.util.HashSet;
import java.util.Set;

public class UserRegistry {
	
	public class User {

        private String uid;

        public User(String uid) {
            this.uid = uid;
        }

        public String getUid() {
            return uid;
        }

        @Override
        public String toString() {
            return uid;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            return uid.equals(user.uid);
        }

        @Override
        public int hashCode() {
            return uid.hashCode();
        }
    }

    private static Set<User> uids;
    private static UserRegistry registry = new UserRegistry();

    public UserRegistry() {
		uids = new HashSet<>();
    }

    public boolean createUser(String uid) {
        return uids.add(new User(uid));
    }

    public boolean removeUser(String uid) {
        return uids.remove(new User(uid));
    }

    public boolean containsUser(String uid) {
        return uids.contains(new User(uid));
    }

    public User get(String uid) {
        if (containsUser(uid)) {
            return new User(uid);
        } else {
            return null;
        }
    }

    public User getAndCreateIfNeeded(String uid) {
        User rtr;
        if (!containsUser(uid)) {
            createUser(uid);
        }
        rtr = get(uid);
        return rtr;
    }

}
