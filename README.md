# DECIDE
[![CircleCI](https://circleci.com/gh/DD2480-Project-group-25/DECIDE/tree/master.svg?style=svg)](https://circleci.com/gh/DD2480-Project-group-25/DECIDE/tree/master)

`DECIDE()` determines whether an interceptor should be launched based upon input radar tracking information.

Refer to the [documentation](https://372-167187406-gh.circle-artifacts.com/0/javadoc/package-summary.html) for more information.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

* JDK 1.8 or greater is needed.
* Gradle is used as build system. Verified to work with Gradle 5.1.1.

### Installing

To get started, you should only need to clone the repo.

cd $SOME_DIR

git clone git@github.com:DD2480-Project-group-25/DECIDE.git

## Running the tests

Use `gradle test` to run the automated test.

## Deployment

Use `gradle build` to build from source.

## Built With

* [Gradle](https://gradle.org) - Dependency Management
* [JUnit4](https://junit.org/junit4/) - Testing framework
* [CircleCI](https://circleci.com) - Continuous integration

## Contributing

Please read [CONTRIBUTING](CONTRIBUTING.md) for details on how to
contribute to project. Before opening a pull request, please verify that the
code builds and passes all tests.

## Authors

* **Alzahraa Salman**
  * Completed LIC 4,9 and 14 with corresponding tests
  * Put together LICs for final decision together with Helena
* **Helena Alinder**
  * Completed LIC 0, 5 and 10 with corresponding tests
  * Put together LICs for final decision together with Alzahraa
* **Jesper Larsson**
    * Completed LIC 3, 8 and 13 with corresponding tests
    * Set up CI
* **Marcus Granström**
  * Completed LIC 2, 7 and 12 with corresponding tests
  * Wrote this readme
* **Veronica Hage**
  * Completed LIC 1, 6 and 11 with corresponding tests

See also the list of [contributors](https://github.com/DD2480-Project-group-25/DECIDE/contributors) who participated in this project.

## License

This project is licensed under the LGPL v3.0 License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments
* `Circle` - [Project Nayuki](https://www.nayuki.io/page/smallest-enclosing-circle), smallest enclosing circle library

## What we are proud of
We managed to setup neat CI environment that checks:
 * tests,
 * format according to our style guide, and
 * that our javadoc can be generated