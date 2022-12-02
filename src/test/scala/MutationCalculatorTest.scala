import MutationCalculator.Mutation
import munit.{CatsEffectSuite, ScalaCheckEffectSuite}
import org.scalacheck.effect.PropF.forAllF

class MutationCalculatorTest extends CatsEffectSuite with ScalaCheckEffectSuite {

  test("Should return mutation for given id") {
    forAllF { id: String =>
      val actual = MutationCalculator.Repository.fetch(id)(Mutation.apply)
      assertIO(actual, Mutation(id))
    }
  }

  test("Should fetch and store for given id") {
    forAllF { id: String =>
      val actual = MutationCalculator.Service.fetchAndStore(id)
      assertIO_(actual)
    }
  }
}
