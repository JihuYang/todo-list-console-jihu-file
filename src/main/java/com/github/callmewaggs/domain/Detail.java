package com.github.callmewaggs.domain;

/** Todo의 content */
public class Detail {

  private long todoId;
  private String memo;
 

  /** Todo에 내용 저장 */
  public Detail(long todoId, String memo) {
    if (memo.equals(" ")) {
      throw new IllegalArgumentException("메모의 내용은 공백일 수 없습니다. 다시 입력해주세요.");
    }
    this.todoId = todoId;
    this.memo = memo;
  }

  public long getTodoId() {
    return todoId;
  }

  public String getMemo() {
	return memo;
  } 
  
  /**
   * update 할 때 수정한 content와 수정일시 저장
   * @param content
   * @param parents
   */
  public void update(String memo) {
    this.memo = memo;
  }

}
