package start;

public class TableDisplay {
	StringBuilder sb = new StringBuilder();
	public TableDisplay(EntityList e) {
		sb.append("         Entity |Price| Description");
		sb.append(System.getProperty("line.separator"));
		for (int i = 0; i < 80; i++) {
			sb.append("-");
		}
		sb.append(System.getProperty("line.separator"));
		for (int i = 0; i < e.getTotalnumber(); i++) {
			sb.append(String.format("%16s|%5s|%57s",e.getentityList()[i].getName(),e.getentityList()[i].getMoney(),e.getentityList()[i].getDescription()));
			sb.append(System.getProperty("line.separator"));
		}
		for (int i = 0; i < 80; i++) {
			sb.append("-");
		}
		System.out.println(sb.toString());
	}
}
//m.shop.getEnlist().getentityList()[i].getName(), m.shop.getEnlist().getentityList()[i].getMoney(), m.shop.getEnlist().getentityList()[i].getDescription()
