package acrm

class StreetAddress {
	static graphql = true

	static constraints = {
		streetName nullable: true
		streetNumber nullable: true
		postalCode nullable: true
		block nullable: true
		apartment nullable: true
		city nullable: true
		state nullable: true
		sector nullable: true
		country nullable: true
	}

	String streetName
	String streetNumber
	String postalCode
	String block
	String apartment
	String city
	String state
	String sector
	String country
}
