import React from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { messageActions } from '../../actions/message.action'

const Message = () => {
  const dispatch = useDispatch()
  const response = useSelector(state => state.messageReducer.response)
  const hide = () => dispatch(messageActions.hide())

  return (
    <>
      {response ? (
        <div>
          <p>{response.message}</p>
          <button
            onClick={() => {
              hide(response)
            }}
          >
            &times;
          </button>
        </div>
      ) : (
        ''
      )}
    </>
  )
}

export default Message
