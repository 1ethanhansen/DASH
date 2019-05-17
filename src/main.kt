var board = arrayOf<Array<Int>>()
var currentPlayer = -1

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

fun move(player : Int, current : Int, next : Int) {
    val col = (current - 1) % 3
    var row = 0
    when {
        current < 4 -> row = 0
        current < 7 -> row = 1
        current < 10 -> row = 2
    }

    if (board[row][col] == player) {
        val colNext = (next - 1) % 3
        var rowNext = 0
        when {
            next < 4 -> rowNext = 0
            next < 7 -> rowNext = 1
            next < 10 -> rowNext = 2
        }
        if (board[rowNext][colNext] == 0) {
            board[row][col] = 0
            board[rowNext][colNext] = player
        }
    }
}

fun checkForWin() : Boolean {
    var output = false

    for (i in 0..2) {
        if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
            output = true
        }
    }

    for (i in 0..2) {
        if (board[i][0] == board[i][2] && board[i][1] == board[i][2]) {
            output = true
        }
    }

    if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
        output = true
    }

    if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
        output = true
    }

    return output
}

fun takeTurn() {
    print("Enter the location of the piece you want to move: ")
    var inputStr = readLine()

    if (inputStr == null) {
        print("Hey that's null")
    }

    val inputPiece = inputStr!!.toInt()

    print("Enter the location you want that piece to move: ")
    inputStr = readLine()

    if (inputStr == null) {
        print("Hey that's null")
    }

    val inputPlace = inputStr!!.toInt()

    move(currentPlayer, inputPiece, inputPlace)

    printBoard()

    currentPlayer *= -1
}

fun main() {
    while (true) {
        initBlank()
        resetBoard()

        options()

        while (checkForWin() == true) {
            takeTurn()
        }
    }
}