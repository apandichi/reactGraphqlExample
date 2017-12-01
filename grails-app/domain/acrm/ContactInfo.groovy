package acrm

class ContactInfo {

	static graphql = true

	static constraints = {
	}

	static belongsTo = [
			person: Person
	]

	Email email
	StreetAddress address
}
