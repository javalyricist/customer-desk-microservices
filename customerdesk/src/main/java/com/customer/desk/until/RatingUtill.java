package com.customer.desk.until;

public class RatingUtill {

	public enum RatingEnum {
		AAA(4), BB(2), B(1),A(3);
		private int rating;

		private RatingEnum(int rating) {
			this.rating = rating;
		}

		public int rating() {
			return rating;
		}
	}
}
