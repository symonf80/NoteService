fun main() {

    val service = NoteService()
    val note = Note()
    val note1 = Note(id = 2)
    val com = Comment(message = "new comment")
    val com1 = Comment(message = "second comment")
    service.add(note)
    service.add(note1)
    service.createComment(1, com)
    service.createComment(2, com1)
    println(service.notes[0])
    println(service.notes[1])
// service.deleteComment(1,1)

// println(service.notes[0])

// println(service.notes[1])

    service.editComment(2,1,"edit message")
    println(service.getById(1))
    println(service.notes[0])
    println(service.notes[1])
// println("\n����� ������ �������")

// println(service.get())

// println("\n�������������� �����������:")

// service.restoreComment(1, 1)

// println(service.notes[0])

}