package com.github.callmewaggs.domain;

import java.time.LocalDateTime;
import java.util.List;

/** Todo의 content */
public class Todo {

  private long id;
  private String content;
  private List<Todo> parents;
  private LocalDateTime createAt;
  private LocalDateTime updateAt;
  private LocalDateTime finishAt;
  private String memo;
 

  /** Todo에 내용 저장 */
  public Todo(long id, String content, List<Todo> parents) {
    if (content.equals(" ")) {
      throw new IllegalArgumentException("할 일의 내용은 공백일 수 없습니다. 다시 입력해주세요.");
    }
    this.id = id;
    this.content = content;
    this.createAt = LocalDateTime.now();
    this.parents = parents;
  }
  
  public Todo(long id, String memo) {
    if (memo.equals(" ")) {
      throw new IllegalArgumentException("메모의 내용은 공백일 수 없습니다. 다시 입력해주세요.");
    }
    this.id = id;
    this.memo = memo;
  }

  public long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public LocalDateTime getCreateAt() {
    return createAt;
  }

  public List<Todo> getParents() {
    return parents;
  }

  public LocalDateTime getUpdateAt() {
    return updateAt;
  }

  public LocalDateTime getFinishAt() {
    return finishAt;
  }

  public String getMemo() {
	return memo;
  } 
  
  /**
   * update 할 때 수정한 content와 수정일시 저장
   * @param content
   * @param parents
   */
  public void update(String content, List<Todo> parents) {
    this.content = content;
    this.parents = parents;
    this.updateAt = LocalDateTime.now();
  }

  /**
   * 최종수정일시 저장 
   */
  public void finish() {
    this.finishAt = LocalDateTime.now();
  }

  /**
   * 의존되어 있는 할 일이 끝났는지 확인
   */
  public void checkFinished() {
    if (this.finishAt == null) {
      throw new IllegalStateException("다른 할 일로 부터 의존되어 있습니다. 완료를 원하는 경우 다른 할 일을 먼저 완료해주세요.");
    }
  }
}
