
public class Date implements Comparable<Date> {
	protected int day, month, year;
	protected String format;

	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.format = "YY-MM-DD";
	}

	public Date(String date) {
		this(date, "YY-MM-DD");
	}

	public Date(String date, String format) {
		this.format = format;
		String delimiter = "-";
		for (int i = 0; i < format.length(); ++i) {
			if (!Character.isLetter(format.charAt(i))) {
				delimiter = Character.toString(format.charAt(i));
				break;
			}
		}
		
		for (int i = 0; i < date.length(); ++i) {
			if (!Character.isDigit(date.charAt(i)) && date.charAt(i) != delimiter.charAt(0)) {
				System.out.println("Wrong Date Format!");
				System.exit(1);
			}
		}

		String[] dateParts = date.split(delimiter);
		if (dateParts.length != 3) {
			System.out.println("Wrong Date Format!");
			System.exit(1);
		}
		String[] formatParts = format.split(delimiter);
		for (int i = 0; i < dateParts.length; ++i) {
			int cur = Integer.valueOf(dateParts[i]);
			switch(formatParts[i]) {
				case "YY":
					this.year = cur;
					break;

				case "MM":
					this.month = cur;
					break;

				case "DD":
					this.day = cur;
					break;

				default:
					System.out.println("Wrong Date Format!");
					System.exit(1);
					break;
			}
		}
	}

	public int getYear() 			{return year;}
	public void setYear(int year)	{this.year = year;}
	public int getMonth()			{return month;}
	public void setMonth(int month)	{this.month = month;}
	public int getDay()				{return day;}
	public void setDay(int day)		{this.day = day;}

	public int compareTo(Date date) {
		if (date.getYear() != this.year)
			return this.year - date.getYear();
		if (date.getMonth() != this.month)
			return this.month - date.getMonth();
		return this.day - date.getDay();
	}

	public String toString() {
		String str = format;
		str = str.replace("YY", Integer.toString(year));
		str = str.replace("MM", Integer.toString(month));
		str = str.replace("DD", Integer.toString(day));
		return str;
	}
}