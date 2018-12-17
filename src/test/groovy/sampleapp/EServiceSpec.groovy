package sampleapp


import grails.testing.gorm.DataTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class EServiceSpec extends Specification implements DataTest, ServiceUnitTest<EService> {

    def setupSpec() {
        mockDomains A, B, C, D, E
    }

    void "Test listE method"() {
        given:
        A instanceOfA = new A(name: 'iName').save(flush: true, failOnError: true)
        B instanceOfB = new B(a: instanceOfA).save(flush: true, failOnError: true)
        C instanceOfC = new C(b: instanceOfB).save(flush: true, failOnError: true)
        D instanceOfD = new D(c: instanceOfC).save(flush: true, failOnError: true)

        10.times {
            new E(d: instanceOfD, isAttribute: true).save(flush: true, failOnError: true)
        }

        when:
        List<E> sampleList = E.findAllByIsAttribute(true)

        then:
        sampleList.size() == 10
        sampleList.every { it.d.c.b.a == instanceOfA }

        when:
        List<E> result = service.listEMethod(instanceOfA)

        then:
        result.size() == 10
    }
}
