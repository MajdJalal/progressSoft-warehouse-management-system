interface WHSTransactionalExecutor {
    fun <T> runOnTransaction(command : () -> T) : T
}