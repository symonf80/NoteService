data class Note(
    var id: Int = 1,
    var title: String = "title",
    var text: String = "text",
    val date: Int = 1,
    val comments: MutableList<Comment> = mutableListOf(),
    val readComments: Int = 1,
    val viewUrl: String = "viewUrl"
)