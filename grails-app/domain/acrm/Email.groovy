package acrm

class Email {
	static graphql = true

	static constraints = {
		emailAddress nullable: false, blank: false, email: true
	}

	String emailAddress
	Boolean isConfirmed
}
