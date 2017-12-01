import {ApolloProvider} from 'react-apollo';
import {ApolloClient} from 'apollo-client';
import {HttpLink} from 'apollo-link-http';
import {InMemoryCache} from 'apollo-cache-inmemory';
import React, {Component} from 'react';
import {graphql} from 'react-apollo';
import gql from 'graphql-tag';

var ReactDOM = require('react-dom');

const client = new ApolloClient({
    link: new HttpLink({uri: "http://localhost:8080/graphql/index"}),
    cache: new InMemoryCache()
});


const personListQuery = gql`query {
  personList(max: 3) {
    id
    name,
    contacts {
      email {
        emailAddress
      }
    }
  }
}`;


client.query({query: personListQuery}).then(console.log)

// Can't make it work to display an html list of some sort.
// I assume it's because the data is read only at a specific time, or there's a delay
const MyComponentWithData = graphql(personListQuery)(props =>
    <div>
        {JSON.stringify(props.data.personList)}
    </div>
);

// This is how I'd like it to work
function renderAsList({data: {personList}}) {
    console.log(personList);
    return (
        <div>
            {personList.map((name) => {
                <p>{name}</p>
            })}
        </div>
    )
}

ReactDOM.render(
    <ApolloProvider client={client}>
        <MyComponentWithData/>
    </ApolloProvider>,
    document.getElementById('app')
);