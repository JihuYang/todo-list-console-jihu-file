package com.github.callmewaggs.detailMenu;

public class DetailMenuParameter {

  private DetailMenu detailMenu;
  private Long todoId;
  private String memo;

  /** menu, id, memo setter */
  public DetailMenuParameter(DetailMenu detailMenu, Long todoId, String memo) {
    this.todoId = todoId;	
	this.detailMenu = detailMenu;
	this.memo = memo;	
  }

  /** 사용자가 입력한 메뉴 저장 후 각 번호에 맞는 행동으로 return */
  public static DetailMenuParameter parse(String input) {
    String[] parsed = input.split(" ");
    
    /** menu에 사용자가 입력한 메뉴 번호 저장 */
    DetailMenu detailMenu = DetailMenu.fromMenuNumber(parsed[0]);
    
    switch (detailMenu) {
      case CREATEDETAIL:
        return createDetail(parsed);
      case UPDATEDETAIL:
        return updateDetail(parsed);
      case REMOVEDETAIL:
        return removeDetail(parsed);     
      default:
        throw new IllegalStateException("Wrong menu. try again.");
    }
  }
  
  private static DetailMenuParameter removeDetail(String[] parsed) {
    long todoId = Long.parseLong(parsed[1]);
    return new DetailMenuParameter(DetailMenu.REMOVEDETAIL, todoId, null);
  }

  private static DetailMenuParameter updateDetail(String[] parsed) {
    long todoId = Long.parseLong(parsed[1]);
    String memo = parsed[2];
    return new DetailMenuParameter(DetailMenu.UPDATEDETAIL, todoId, memo);
  }

  private static DetailMenuParameter createDetail(String[] parsed) {
	long todoId = Long.parseLong(parsed[1]);
    String memo = parsed[2];
    return new DetailMenuParameter(DetailMenu.CREATEDETAIL, todoId, memo);
  }

  /** detailMenu getter */
  public DetailMenu getDetailMenu() {
    return detailMenu;
  }

  /** todoId getter */
  public Long getTodoId() {
    return todoId;
  }
  
  /** memo getter */
  public String getMemo() {
    return memo;
  }
  
}
