package sampleapp

class EService {

    List<E> listEMethod(A instanceOfA) {
        List<E> eList = E.where {
            (isAttribute == true) && (d.c.b.a == instanceOfA)
        }.list()

        return eList
    }

}