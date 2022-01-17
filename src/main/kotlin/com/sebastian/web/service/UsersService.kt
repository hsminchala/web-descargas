package com.sebastian.web.service

import com.sebastian.web.model.UsersModel
import com.sebastian.web.repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UsersService {
    @Autowired
    lateinit var usersRepository: UsersRepository


    fun list(): List<UsersModel> {
        return usersRepository.findAll()
    }

    fun getUser(username: String?): UsersModel?{
        try {
            val response = usersRepository.findByUsername(username)
                ?: throw Exception("No existe el usuario")
            return response
        } catch (ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun update(user: UsersModel): UsersModel {
        return usersRepository.save(user)
    }

    fun delete (id:Long): Boolean{
        usersRepository.deleteById(id)
        return true
    }

    //metodos de la logica
    fun calcMultiplicationTest(index: Int, number:Int):Int{
    if (index % 2 == 0){
    return number * 2;
    }
        return number * 1
    }

    fun restNine(num:Int):Int{
    if (num in 10..18){
        return num - 9
        }
        return num
    }

    fun substractFromNextTen(ins:Int):Int{
            var igg:Int = (ins/10) + 1
            var  tis = igg * 10
        return tis - ins
    }


    fun validarCedula(x: String):Boolean {
        var suma = 0
        return if (x.length == 9) {
            println("Ingrese su cedula de 10 digitos")
            false
        } else {
            val a = IntArray(x.length / 2)
            val b = IntArray(x.length / 2)
            var c = 0
            var d = 1
            for (i in 0 until x.length / 2) {
                a[i] = x[c].toString().toInt()
                c += 2
                if (i < x.length / 2 - 1) {
                    b[i] = x[d].toString().toInt()
                    d += 2
                }
            }
            for (i in a.indices) {
                a[i] = a[i] * 2
                if (a[i] > 9) {
                    a[i] = a[i] - 9
                }
                suma = suma + a[i] + b[i]
            }
            val aux = suma / 10
            val dec = (aux + 1) * 10
            if (dec - suma == x[x.length - 1].toString()
                    .toInt()
            ) true else suma % 10 == 0 && x[x.length - 1] == '0'
        }
    }

}
