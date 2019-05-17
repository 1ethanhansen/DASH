var board = arrayOf<Array<Int>>()

fun initBlank() {
    for (i in 0..2) {
        var array = arrayOf<Int>()
        for (j in 0..2) {
            array += 0
        }
        board += array
    }
}

fun resetBoard() {
    for (i in 0..2) {
        var array = arrayOf<Int>()
        for (j in 0..2) {
            array += 0
        }
        board[i] = array
    }

    board[0][0] = 1
    board[0][2] = 1
    board[2][1] = 1

    board[0][1] = -1
    board[2][0] = -1
    board[2][2] = -1
}

fun printBoard() = board.forEach {
    it.forEach { cell ->
        print("$cell \t")
    }
    println()
}

fun options() {
    println("\n\nEnter an option: ")
    print("1: start 1 player\n2: start 2 players\n3: rules ")
    val option = readLine()

    when (option) {
        "3" -> rules()
    }
}

fun rules() {
    println("Welcome to DASH\nThe rules here are pretty simple, you start with a 3x3 board layed out like this:")
    resetBoard()
    printBoard()
    println("""The goal is to get all of your pieces in a row, which can be diagonal, vertical, or horizontal.
A player's pieces are either 1 or -1, and a 0 represents an empty space.
When it is your turn, you will be shown the board and can select which piece you want to move.
Select the piece by entering the square that the piece is on, where squares are defined like this:
1   2   3
4   5   6
7   8   9
Then you select the square you want that piece to move to, in the same way.
Here is an example: say the board has just been started. (see above for starting configuration)
Player -1 could select piece 7 to move and move it to square 5""")
}

fun move(current : Int, next : Int, player : Int) {
    
}

fun main() {
    while (true) {
        initBlank()
        resetBoard()

        options()
    }
}