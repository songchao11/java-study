package com.study.enumtest;

public class EnumTest {

	public static void main(String[] args) {
		System.out.println(SeasonEnum.SPRING.getComment());
		System.out.println(SeasonEnum.parse("spring"));
	}
	
}

/*
 * ¼¾½ÚÃ¶¾Ù
 */
enum SeasonEnum{
	
	SPRING("spring", "´ºÅ¯»¨¿ª"),
	SUMMER("summer", "ÏÄÈÕÑ×Ñ×"),
	AUTUMN("autumn", "Çï¸ßÆøË¬"),
	WINTER("winter", "°×Ñ©°¨°¨");
	
	
	private String value;
	
	private String comment;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	SeasonEnum(String value, String comment) {
		this.value = value;
		this.comment = comment;
	}
	
	public static SeasonEnum parse(String value) {
        if (value != null) {
            SeasonEnum[] array = values();
            for (SeasonEnum each : array) {
                if (value == each.value) {
                    return each;
                }
            }
        }
        return null;
    }
	
}
