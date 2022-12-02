ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

val MunitVersion            = "0.7.29"
val MunitCatsEffectVersion  = "1.0.7"
val ScalacheckEffectVersion = "1.0.4"

lazy val root = (project in file("."))
  .settings(
    name := "mutation-test-poc",
    libraryDependencies := Seq(
      "org.typelevel" %% "cats-core"               % "2.9.0",
      "org.typelevel" %% "cats-effect"             % "3.4.1",
      "org.http4s"    %% "http4s-ember-server"     % "0.23.16",
      "org.http4s"    %% "http4s-circe"            % "0.23.16",
      "org.scalameta" %% "munit"                   % MunitVersion            % Test,
      "org.scalameta" %% "munit-scalacheck"        % MunitVersion            % Test,
      "org.typelevel" %% "munit-cats-effect-3"     % MunitCatsEffectVersion  % Test,
      "org.typelevel" %% "scalacheck-effect-munit" % ScalacheckEffectVersion % Test
    )
  )
