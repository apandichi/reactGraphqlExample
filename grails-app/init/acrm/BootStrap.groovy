package acrm

class BootStrap {

	def init = { servletContext ->
		def person = new Person(
				name: "Alex B"
		)

		person.addToContacts(
				new ContactInfo(
						email: new Email(emailAddress:  "a@b.com", isConfirmed: true),
						address: new StreetAddress(
								streetName: "C",
								streetNumber: "3",
								sector: "3",
								city: "Bucharest",
								country: "Romania"
						)
				)
		)

		person.save(failOnError: true)
	}
	def destroy = {
	}
}
