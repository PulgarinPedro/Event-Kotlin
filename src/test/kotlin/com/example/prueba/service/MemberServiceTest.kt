package com.example.prueba.service
import com.example.prueba.model.Member
import com.example.prueba.repository.MemberRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class MemberServiceTest {
    @InjectMocks
    lateinit var memberService: MemberService

    @Mock
    lateinit var memberRepository: MemberRepository

    val memberMock = Member().apply {
        id = 1
        nui = "0106977523"
        fullname = "Pedro Pulgarin"
        email = "pjpulgarin@sudamericano.edu.ec"
        age=19
    }
    @Test
    fun saveEventWhenIsCorrect() {
        Mockito.`when`(memberRepository.save(Mockito.any(Member::class.java))).thenReturn(memberMock)
        val response = memberService.save(memberMock)
        Assertions.assertEquals(response.id, memberMock.id)
    }

    @Test
    fun saveEventWhenIsEmailIsBlank() {
        Assertions.assertThrows(Exception::class.java) {
            memberMock.apply { email = " " }
            Mockito.`when`(memberRepository.save(Mockito.any(Member::class.java))).thenReturn(memberMock)
            memberService.save(memberMock)
        }
    }

}