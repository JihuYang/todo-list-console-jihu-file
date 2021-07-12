package com.github.callmewaggs.detailProcessor;

import com.github.callmewaggs.domain.Detail;
import com.github.callmewaggs.domain.DetailRepository;
import com.github.callmewaggs.domain.Todo;
import com.github.callmewaggs.domain.TodoRepository;
import com.github.callmewaggs.menu.TodoMenuParameter;


/** Detail 생성 */
public class DetailCreateProcessor implements DetailProcessor {

  private TodoRepository todoRepository;
  private DetailRepository detailRepository;

  public DetailCreateProcessor(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;    
  }

  @Override
  public void run(TodoMenuParameter todoMenuParameter) {
    Todo toBeCreated = todoRepository.find(todoMenuParameter.getId());
    Detail detail = new Detail(toBeCreated.getId(), todoMenuParameter.getContent());
    detailRepository.add(detail);
  }
}
