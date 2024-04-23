package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.OrderRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderServiceTest {

    @Autowired EntityManager em;
    @Autowired OrderService orderService;
    @Autowired OrderRepository orderRepository;

  @Test
  public void 상품주문() throws Exception {
      //given
      Member member = new Member();
      member.setName("회원1");
      member.setAddress(new Address("서울", "강가", "231-123"));
      em.persist(member);

      Book book = new Book();
      book.setName("JPA 기초");
      book.setPrice(10000);
      book.setStockQuantity(10);
      em.persist(book);

      //when
      int orderCount = 2;
      Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

      //then
      Order getOrder = orderRepository.findOne(orderId);

      Assert.assertEquals("상품 주문 시 상태는 ORDER", OrderStatus.ORDER, getOrder.getStatus());
  }

  @Test
  public void () throws Exception {
      //given

      //when

      //then

  }

  @Test
  public void () throws Exception {
      //given

      //when

      //then

  }

}