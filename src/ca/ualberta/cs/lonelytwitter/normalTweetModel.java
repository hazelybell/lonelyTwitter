package ca.ualberta.cs.lonelytwitter;

public class normalTweetModel extends lonelyTweetModel {

	public normalTweetModel(String text) {
		super(text);
	}

	@Override
	public void setText(String text) {
		
	}
	
	@Override
	public void setImportant(boolean important) throws Exception {
		if (important) {
			throw new IllegalArgumentException();
		}
		this.important = important;
	}


}
