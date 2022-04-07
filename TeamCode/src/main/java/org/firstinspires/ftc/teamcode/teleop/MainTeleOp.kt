package org.firstinspires.ftc.teamcode.teleop.MainTeleOp

import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcare.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotor
import org.firstinspires.ftc.teamcode.utils.hardware.Servos
import org.firstinspires.ftc.teamcode.terminator.Wheels

@TeleOp(name = "MainTeleOp")
class MainTeleOp : OpMode(){
    val servos = Servos()
    val wheels = Wheels()
    val modHeil : Boolean = true
    override fun init() {
        wheels.init(hardwareMap)
        wheels.start()
        wheels.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER)
        servos.init(hardwareMap)
        servos.start()
    }
    private fun drive() {
        val a = gamepad1.left_stick_x.toDouble()
        val b = gamepad1.left_stick_y.toDouble()
        val c = gamepad1.right_stick_x.toDouble()

        wheels.frontRightMotor.power = (b - a - c)
        wheels.frontLeftMotor.power = (b + a + c)
        wheels.rearRightMotor.power = (b + a - c)
        wheels.rearLeftMotor.power = (b - a + c)


    }
    override  fun loop () {
        drive()
        if (gamepad1.a) {
            servos.setPosition(0.1)
        }
        if (gamepad1.y) {
            servos.setPosition(0.9)
        }
    }

}