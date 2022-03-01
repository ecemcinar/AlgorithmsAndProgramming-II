
public class User { // for the store data in highscoretable.txt, I'll create user objects.

	private int score;
	private String name;

	public User(String name, int score) {
		this.name = name;
		this.score = score;

	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
