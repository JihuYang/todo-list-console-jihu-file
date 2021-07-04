package com.github.callmewaggs.domain;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;


/** Todo에 대한 저장소 역할 */
public class TodoRepository {

  private List<Todo> todoList;

  public TodoRepository() {
    this.todoList = new ArrayList<>();
  }

  public void add(Todo todo) {
    todoList.add(todo);
  }

  /** 사용자가 입력한 번호를 찾아 return */
  public Todo find(long id) {
    return todoList.stream()
        .filter(todo -> todo.getId() == id)
        .findFirst()
        .orElseThrow(() -> new IllegalStateException("잘못된 id가 입력되었습니다. id를 다시 확인해 주세요."));
  }

  public List<Todo> findAll() {
    return todoList;
  }

  public List<Todo> findAll(List<Long> ids) {
    List<Todo> todos = new ArrayList<>();
    for (long id : ids) {
      Todo todo = find(id);
      todos.add(todo);
    }
    return todos;
  }

  public List<Todo> findAllChildren(long id) {
    List<Todo> children = new ArrayList<>();
    for (Todo todo : todoList) {
      if (todo.getParents().stream().anyMatch(e -> e.getId() == id)) {
        children.add(todo);
      }
    }
    return children;
  }

  public void remove(Todo todo) {
    todoList.remove(todo);
  }

  public int size() {
    return todoList.size();
  }
  
	public List<Todo> searchAll(String content) {
		List<Todo> searched = new ArrayList<>();
		for (Todo todo : todoList) {
			if (todo.getContent().contains(content)) {
				searched.add(todo);
			}
		}
		return searched;
	}

	public List<Todo> searchAllStream(String content) {
		List<Todo> searched = new ArrayList<>();
		searched.addAll(
				todoList.stream().filter(todo -> todo.getContent().contains(content)).collect(Collectors.toList()));
		return searched;
	}
	
	public List<Todo> check() {
		List<Todo> checked = new ArrayList<>();
	    for (Todo todo : todoList) {
	        if(todo.getFinishAt() == null)
	        	checked.add(todo);
	      }
		return checked;
	}	

}
