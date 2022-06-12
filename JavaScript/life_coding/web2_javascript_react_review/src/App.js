import { useState } from 'react';
import './App.css';

function Header(props) {
  const current = props.title;
  return (    
    <h1><a href="/" onClick={(event)=>{
      event.preventDefault();
      props.onChangeMode();
    }}>{current}</a></h1>
  )
}

function Nav(props) {
  const lis = [];  
  for(let i = 0; i < props.topics.length; i++) {
    let t = props.topics[i];
    lis.push(<li key={t.id}>
      <a id={t.id} href={'/read/'+t.id} onClick={(event)=>{
        event.preventDefault();
        props.onChangeMode(Number(event.target.id));
      }}>{t.title}</a>
    </li>)
  }
  return (
    <nav>
      <ol>
        {lis}
      </ol>
    </nav>
  )
}

function Article(props) {
  return (
    <div>
      <h2>{props.title}</h2>
      {props.body}
    </div>
  )
}

function Create(props) {
  return (
    <article>
      <h2>Create</h2>
      <form onSubmit={(event)=>{
        event.preventDefault();
        const title = event.target.title.value;
        const body = event.target.body.value
        props.onCreate(title, body);
      }}>
        <p><input type="text" name="title" placeholder='title'/></p>
        <p><textarea name="body" placeholder='body'></textarea></p>
        <p><input type="submit" value="Create"></input></p>
      </form>
    </article>
  )
}


function App() {
  const [mode, setMode] = useState('WELCOME');
  const [id, setId] = useState(null);
  const [topics, setTopics] = useState([
    {id:1, title:'html', body: 'html is...'},
    {id:2, title:'css', body: 'css is...'},
    {id:3, title:'javascript', body: 'javascript is...'}
  ]);
  let content = null;

  if(mode === 'WELCOME') {
    content = <Article title='Welcome' body='Hello, WEB'></Article>
  } else if(mode ==='READ') {
    let title, body = null;
    for(let i = 0; i < topics.length; i++){
      if(topics[i].id === id ) {
        title = topics[i].title;
        body = topics[i].body
      }
    }
    content = <Article title={title} body={body}></Article>
  } else if(mode === 'CREATE') {
    content = <Create onCreate={(_title, _body)=>{
      const newTopic = {id:topics.length+1, title:_title, body:_body};
      let newTopics = [...topics];
      newTopics.push(newTopic);
      setTopics(newTopics);
      setId(topics.length+1);
      setMode('READ');
    }}></Create>
  }
  
  return (
    <div>
      <Header title="WEB" onChangeMode={()=>{
        setMode("WELCOME");
      }}></Header>
      <Nav topics={topics} onChangeMode={(_id)=>{
        setId(_id);
        setMode("READ");
      }}></Nav>
      {content}
      <a href="/create" onClick={(event)=> {
        event.preventDefault();
        setMode('CREATE');
      }}>Create</a>
    </div>
  );
}

export default App;
