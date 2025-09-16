open class Cuenta(
    saldoInicial: Float,
    tasaAnual: Float
) {
    protected var saldo: Float = saldoInicial
    protected var numeroConsignaciones: Int = 0
    protected var numeroRetiros: Int = 0
    protected var tasaAnual: Float = tasaAnual
    protected var comisionMensual: Float = 0f

    open fun consignar(monto: Float) {
        require(monto > 0f) { "El monto a consignar debe ser positivo." }
        saldo += monto
        numeroConsignaciones++
    }


    open fun retirar(monto: Float) : Boolean {
        require(monto > 0f) { "El monto a retirar debe ser positivo." }
        if (monto > saldo) return false
        saldo -= monto
        numeroRetiros++
        return true
    }

    protected fun interesMensualCalculado(): Float {
        val tasaMensual = (tasaAnual / 12f) / 100f
        return saldo * tasaMensual
    }

    open fun calcularInteresMensual() {
        saldo += interesMensualCalculado()
    }

    open fun extractoMensual() {
        saldo -= comisionMensual
        calcularInteresMensual()
        comisionMensual = 0f
    }

    open fun imprimir() {
        println("=== Cuenta (Base) ===")
        println("Saldo: $saldo")
        println("Consignaciones: $numeroConsignaciones")
        println("Retiros: $numeroRetiros")
        println("Tasa anual (%): $tasaAnual")
        println("Comisión mensual: $comisionMensual")
    }
}
