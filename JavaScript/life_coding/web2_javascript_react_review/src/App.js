import logo from './logo.svg';
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
        props.onChangeMode(event.target.id);
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

function App() {
  const topics = [
    {id:1, title:'html', body: 'html is...'},
    {id:2, title:'css', body: 'css is...'},
    {id:3, title:'js', body: 'js is...'}
  ];
  return (
    <div>
      <Header title="WEB" onChangeMode={()=>{
        alert('Header');
      }}></Header>
      <Nav topics={topics} onChangeMode={(event)=>{
        alert(event);
      }}></Nav>
      <Article title="Welcome" body="Hello"></Article>
    </div>
  );
}

export default App;
