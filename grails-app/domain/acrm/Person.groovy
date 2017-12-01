package acrm

class Person {
	static graphql = true

	static constraints = {
	}

	static hasMany = [
	        contacts: ContactInfo
	]

	String name
}
