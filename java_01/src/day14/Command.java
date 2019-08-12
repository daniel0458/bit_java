package day14;

public interface Command {
	public void exec();
	default public void check() { 
		System.out.println("Command check() 함수 ");
	}
}

class DeleteCommand implements Command {

	@Override
	public void exec() {
		System.out.println("Delete(삭제)작업 수행");
	}
	public void check() {
		System.out.println("DeleteCommand check() 함수 ");
	}
}

class InsertCommand implements Command {

	@Override
	public void exec() {
		System.out.println("Insert(등록)작업 수행");
	}
}

class UpdateCommand implements Command {

	@Override
	public void exec() {
		System.out.println("Update(수정)작업 수행");
	}
}

class ListCommand implements Command {

	@Override
	public void exec() {
		System.out.println("List(목록)작업 수행");
	}
}