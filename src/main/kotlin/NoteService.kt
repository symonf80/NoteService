class NoteService {

    var notes = mutableListOf<Note>()
    private var noteId: Int = 0

    fun add(note: Note) {
        if (notes.isEmpty()) {
            noteId = 1
        } else {
            note.id = notes.last().id + 1
        }
        notes.add(note)
    }

    fun createComment(id: Int, comment: Comment) {
        for (note in notes) {
            if (id == note.id) {
                if (note.comments.isEmpty()) {
                    comment.noteId = 1
                } else {
                    comment.noteId = note.comments.last().noteId + 1
                }
                note.comments.add(comment)
            }
        }
    }

    fun delete(id: Int) {
        val iterator = notes.iterator()
        while (iterator.hasNext()) {
            if (id == iterator.next().id) {
                iterator.remove()
            }
        }
    }

    fun deleteComment(noteId: Int, commentId: Int) {
        for (note in notes) {
            if (noteId == note.id) {
                for (comment in note.comments) {
                    if (comment.noteId == commentId && !comment.isDeleted) {
                        comment.isDeleted = true

                    }
                }
            }
        }
    }

    fun edit(id: Int, title: String, text: String) {
        for (note in notes) {
            if (id == note.id) {
                note.title = title
                note.text = text
            }
        }
    }

    fun editComment(noteId: Int, commentId: Int, message: String) {
        for (note in notes) {
            if (noteId == note.id) {
                for (comment in note.comments) {
                    if (comment.noteId == commentId && !comment.isDeleted) {
                        comment.message = message
                    }
                }
            }
        }
    }

    fun get(): List<Note>? {
        return notes.ifEmpty {
            null
        }
    }

    fun getById(id: Int): Note? {
        for (note in notes) {
            if (id == note.id) {
                return note
            }
        }
        return null
    }

    fun getComment(noteId: Int): List<Comment>? {
        val comments = mutableListOf<Comment>()
        for (note in notes) {
            if (note.id == noteId) {
                for (comment in note.comments) {
                    if (!comment.isDeleted) {
                        comments.add(comment)
                    }
                }
                return comments
            }
        }
        return null
    }

    fun restoreComment(noteId: Int, commentId: Int) {
        for (note in notes) {
            if (noteId == note.id) {
                for (comment in note.comments) {
                    if (comment.noteId == commentId && comment.isDeleted) {
                        comment.isDeleted = false
                    }
                }
            }
        }
    }
}