import cats.effect.IO

object MutationCalculator {

  case class Mutation(id: String)
  object Repository {
    def fetch(id: String)(get: String => Mutation): IO[Mutation] =
      IO.delay(get(id))

    def store(mutation: Mutation): IO[Unit] = IO.unit
  }

  object Service {
    def fetchAndStore(id: String): IO[Unit] =
      Repository.fetch(id)(Mutation.apply).flatMap(Repository.store)
  }

}
