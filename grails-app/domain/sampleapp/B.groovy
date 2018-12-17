package sampleapp

class B {

    static hasMany = [c: C]
    static belongsTo = [a: A]


    static constraints = {
    }
}
