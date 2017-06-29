/*
 * Copyright (C) 2016 Reece H. Dunn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.co.reecedunn.intellij.plugin.xquery.lexer;

import com.intellij.lexer.Lexer;
import com.intellij.lexer.LexerBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uk.co.reecedunn.intellij.plugin.xqdoc.lexer.XQDocLexer;

import java.util.HashMap;
import java.util.Map;

public class CombinedLexer extends LexerBase {
    class State {
        final Lexer lexer;
        final int state;
        final int parentState;
        final IElementType transition;

        State(Lexer lexer, int state, int parentState, IElementType transition) {
            this.lexer = lexer;
            this.state = state;
            this.parentState = parentState;
            this.transition = transition;
        }
    }

    private final Lexer mLanguage;
    private final Map<Integer, State> mStates = new HashMap<>();
    private final Map<IElementType, State> mTransitions = new HashMap<>();
    private int mStateMask;

    private Lexer mActiveLexer;
    private int mState;

    private static final int STATE_LEXER_XQDOC = 0x70000000;

    public CombinedLexer(Lexer language) {
        mLanguage = language;
        mStateMask = 0;
        addState(new XQDocLexer(), STATE_LEXER_XQDOC, XQueryLexer.STATE_XQUERY_COMMENT, XQueryTokenType.COMMENT);
    }

    private void addState(Lexer lexer, int stateId, int parentStateId, IElementType transition) {
        State state = new State(lexer, stateId, parentStateId, transition);
        mStates.put(stateId, state);
        mTransitions.put(transition, state);
        mStateMask |= stateId;
    }

    // region Lexer

    @Override
    public final void start(@NotNull CharSequence buffer, int startOffset, int endOffset, int initialState) {
        mState = initialState & mStateMask;
        State state = mStates.getOrDefault(mState, null);
        if (state != null) {
            mActiveLexer = state.lexer;
            mLanguage.start(buffer, startOffset, endOffset, state.parentState);
            mActiveLexer.start(mLanguage.getBufferSequence(), mLanguage.getTokenStart(), mLanguage.getTokenEnd(), initialState & ~mStateMask);
        } else {
            mLanguage.start(buffer, startOffset, endOffset, initialState & ~mStateMask);
            mActiveLexer = mLanguage;
        }
    }

    @Override
    public void advance() {
        if (mState == STATE_LEXER_XQDOC) {
            mActiveLexer.advance();
            if (mActiveLexer.getTokenType() == null) {
                mLanguage.advance();
                mState = 0;
                mActiveLexer = mLanguage;
            }
        } else {
            mLanguage.advance();
            State state = mTransitions.getOrDefault(mLanguage.getTokenType(), null);
            if (state != null) {
                mActiveLexer = state.lexer;
                mActiveLexer.start(mLanguage.getBufferSequence(), mLanguage.getTokenStart(), mLanguage.getTokenEnd(), 0);
                mState = state.state;
            }
        }
    }

    @Override
    public int getState() {
        return mActiveLexer.getState() | mState;
    }

    @Nullable
    @Override
    public IElementType getTokenType() {
        return mActiveLexer.getTokenType();
    }

    @Override
    public int getTokenStart() {
        return mActiveLexer.getTokenStart();
    }

    @Override
    public int getTokenEnd() {
        return mActiveLexer.getTokenEnd();
    }

    @NotNull
    @Override
    public CharSequence getBufferSequence() {
        return mLanguage.getBufferSequence();
    }

    @Override
    public int getBufferEnd() {
        return mLanguage.getBufferEnd();
    }

    // endregion
}
