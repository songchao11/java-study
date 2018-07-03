package com.study.enumtest;

public class EnumTest {

	public static void main(String[] args) {
		System.out.println(SeasonEnum.SPRING.getComment());
		System.out.println(SeasonEnum.parse("spring"));
	}
	
}

/*
 * ����ö��
 */
enum SeasonEnum{
	
	SPRING("spring", "��ů����"),
	SUMMER("summer", "��������"),
	AUTUMN("autumn", "�����ˬ"),
	WINTER("winter", "��ѩ����");
	
	
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
