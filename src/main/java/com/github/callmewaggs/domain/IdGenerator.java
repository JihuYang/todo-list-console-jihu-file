package com.github.callmewaggs.domain;

/** Todo의 고유성을 보장하기 위해 id를 발급 */
public class IdGenerator {

  private long id;

  public IdGenerator() {
    this.id = 1;
  }

  public long generate() {
    return id++;
  }
}
